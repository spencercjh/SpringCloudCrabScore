import logging
import os
import re
import sys
import threading
import uuid

import xlwt as xlwt

from src.mail import send_mail

curPath = os.path.abspath(os.path.dirname(__file__))
rootPath = os.path.split(curPath)[0]
sys.path.append(rootPath)
from src.util.config_util import config
from flask import render_template, Blueprint, jsonify, request

LOG_FORMAT = ('%(levelname) -10s %(asctime)s %(name) -30s %(funcName) '
              '-35s %(lineno) -5d: %(message)s')
logging.basicConfig(level=logging.DEBUG, format=LOG_FORMAT)
LOGGER = logging.getLogger("api")

excel_service = Blueprint('excel_service', __name__)


@excel_service.route('/')
def home():
    return render_template('home.html')


@excel_service.route('/hello')
def hello():
    return "Hello World Generate Excel"


def judge_email(email):
    patten = re.compile(r"^([A-Za-z0-9_\-.])+@([A-Za-z0-9_\-.])+\.([A-Za-z]{2,4})$")
    return re.match(patten, email) is not None


@excel_service.route('/generate', methods=['POST'])
def generate():
    competition_id = request.values.get("competition_id")
    if competition_id is None or not competition_id.isdigit():
        return jsonify({
            "code": 405,
            "message": "参数错误",
            "body": {},
            "status": False
        })
    file_id = str(uuid.uuid1())
    thread = threading.Thread(target=service, args=(competition_id, file_id))
    thread.start()
    return jsonify({
        "code": 200,
        "message": "请求成功",
        "body": file_id,
        "status": True
    })


def service(competition_id, file_id):
    LOGGER.debug("thread start")
    db_data = get_db_data(competition_id)
    file_path, file_name = generate_excel(db_data, file_id)
    send_mail(db_data['admin_emails'], file_path, file_name)


def get_db_data(competition_id):
    rxpbdb = {}
    cursor = config.get_mysql_cursor()
    cursor.execute('SELECT * FROM rxpb_user_info WHERE role_id=1 and status=1')
    admins = cursor.fetchall()
    rxpbdb['admin_emails'] = []
    for admin in admins:
        if judge_email(admin['email']):
            rxpbdb['admin_emails'].append(admin['email'])
    cursor.execute('SELECT * FROM rxpbdb.rxpb_company_info ORDER BY company_id')
    rxpbdb["all_company"] = cursor.fetchall()
    cursor.execute('SELECT group_id,'
                   'a.company_id,'
                   'company_name,'
                   'avatar_url,'
                   'a.competition_id,'
                   '((quality_score_m + quality_score_f) / 2) AS score,'
                   'a.create_date,'
                   'a.create_user,'
                   'a.update_date,'
                   'a.update_user '
                   'FROM rxpb_group_info AS a '
                   'LEFT JOIN rxpb_company_info AS b '
                   'ON a.competition_id = b.competition_id '
                   'AND a.company_id = b.company_id '
                   'WHERE a.competition_id = %s '
                   'ORDER BY score DESC '
                   % str(competition_id))
    rxpbdb['rank_quality'] = cursor.fetchall()
    cursor.execute('SELECT group_id,'
                   'a.company_id,'
                   'company_name,'
                   'avatar_url,'
                   'a.competition_id,'
                   '((taste_score_m + taste_score_f)/ 2) AS score,'
                   'a.create_date,'
                   'a.create_user,'
                   'a.update_date,'
                   'a.update_user '
                   'FROM rxpb_group_info AS a '
                   'LEFT JOIN rxpb_company_info AS b '
                   'ON a.competition_id = b.competition_id '
                   'AND a.company_id = b.company_id '
                   'WHERE a.competition_id = %s '
                   'ORDER BY score DESC'
                   % str(competition_id))
    rxpbdb['rank_taste'] = cursor.fetchall()
    cursor.execute('SELECT group_id,'
                   'a.company_id,'
                   'company_name,'
                   'avatar_url,'
                   'a.competition_id,'
                   '((fatness_score_m + fatness_score_f)/ 2) AS score,'
                   'a.create_date,'
                   'a.create_user,'
                   'a''.update_date,'
                   'a.update_user '
                   'FROM rxpb_group_info AS a '
                   'LEFT JOIN rxpb_company_info AS b '
                   'ON a.competition_id = b.competition_id '
                   'AND a.company_id = b.company_id '
                   'WHERE a.competition_id = %s '
                   'ORDER BY score DESC'
                   % str(competition_id))
    rxpbdb['rank_fatness'] = cursor.fetchall()
    cursor.execute('SELECT group_id,'
                   'a.company_id,'
                   'b.company_name,'
                   'b.avatar_url, '
                   'a.competition_id,'
                   'fatness_score_m,'
                   'quality_score_m,'
                   'taste_score_m, '
                   'fatness_score_f,'
                   'quality_score_f, '
                   'taste_score_f,'
                   'a.create_date,'
                   'a.create_user,'
                   'a.update_date, '
                   'a.update_user '
                   'from rxpb_group_info as a '
                   'LEFT JOIN rxpb_company_info as b '
                   'ON a.company_id = b.company_id '
                   'AND a.competition_id = b.competition_id '
                   'where a.competition_id =%s' % str(competition_id))
    rxpbdb['all_group'] = cursor.fetchall()
    rxpbdb['quality_score'] = []
    rxpbdb['taste_score'] = []
    rxpbdb['fatness_score'] = []
    for group in rxpbdb['all_group']:
        cursor.execute('SELECT crab_id, group_id, crab_sex, score_fin '
                       'FROM rxpb_score_quality '
                       'WHERE group_id=%s GROUP BY group_id, crab_sex, crab_id, score_fin ' % str(group['group_id']))
        rxpbdb['quality_score'].append(cursor.fetchall())
        cursor.execute('SELECT crab_id, group_id, crab_sex, score_fin '
                       'FROM rxpb_score_taste '
                       'WHERE group_id=%s GROUP BY group_id, crab_sex, crab_id, score_fin' % str(group['group_id']))
        rxpbdb['taste_score'].append(cursor.fetchall())
        cursor.execute(
            'SELECT group_id, crab_id, crab_sex, crab_weight, crab_length, crab_fatness '
            'FROM rxpb_crab_info '
            'WHERE group_id=%s GROUP BY group_id, crab_sex, crab_id, crab_weight,crab_length,crab_fatness' % str(group['group_id']))
        rxpbdb['fatness_score'].append(cursor.fetchall())
    cursor.close()
    return rxpbdb


def generate_excel(data: dict, file_id: str):
    file_name = file_id + ".xls"
    if os.path.exists("./" + file_name):
        os.remove("./" + file_name)
    write_excel = xlwt.Workbook(encoding='utf-8')
    fatness_score_sheet = write_excel.add_sheet('金蟹奖、优质奖-肥满度')
    fatness_rank_sheet = write_excel.add_sheet('金蟹奖、优质奖-排序')
    quality_score_sheet = write_excel.add_sheet('最佳种质奖')
    quality_rank_sheet = write_excel.add_sheet('最佳种质奖-排序')
    taste_score_sheet = write_excel.add_sheet('口感奖-专家')
    taste_rank_sheet = write_excel.add_sheet('口感奖-排序')
    all_company_sheet = write_excel.add_sheet('参赛单位')
    row = 0
    for company in data['all_company']:
        all_company_sheet.write(row, 0, company['company_id'])
        all_company_sheet.write(row, 1, company['company_name'])
        row += 1
    row = 0
    for fatness in data['rank_fatness']:
        fatness_rank_sheet.write(row, 0, '第' + str(fatness['group_id']) + '组')
        fatness_rank_sheet.write(row, 1, fatness['company_name'])
        fatness_rank_sheet.write(row, 2, fatness['score'])
        fatness_rank_sheet.write(row, 3, str(row + 1))
        row += 1
    row = 0
    for quality in data['rank_quality']:
        quality_rank_sheet.write(row, 0, '第' + str(quality['group_id']) + '组')
        quality_rank_sheet.write(row, 1, quality['company_name'])
        quality_rank_sheet.write(row, 2, quality['score'])
        quality_rank_sheet.write(row, 3, str(row + 1))
        row += 1
    row = 0
    for taste in data['rank_taste']:
        taste_rank_sheet.write(row, 0, '第' + str(taste['group_id']) + '组')
        taste_rank_sheet.write(row, 1, taste['company_name'])
        taste_rank_sheet.write(row, 2, taste['score'])
        taste_rank_sheet.write(row, 3, str(row + 1))
        row += 1
    row = 0
    worker_directory = os.path.abspath(os.path.dirname(__file__)) + "/assert/"
    write_excel.save(worker_directory + file_name)
    return worker_directory + file_name, file_name
