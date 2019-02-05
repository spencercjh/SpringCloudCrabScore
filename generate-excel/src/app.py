import json
import os
import sys

from src import create_app

curPath = os.path.abspath(os.path.dirname(__file__))
rootPath = os.path.split(curPath)[0]
sys.path.append(rootPath)

from flask import request, render_template, Blueprint

excel_service = Blueprint('excel_service', __name__)
app = create_app()


# noinspection PyUnresolvedReferences
@excel_service.route('/')
def home():
    return render_template('home.html')


@excel_service.route('/generate', methods=['POST'])
def get_data():
    if request.method == 'POST':
        rank_fatness = json.loads(request.form['rank_fatness'])
        print(str(rank_fatness))
        rank_quality = json.loads(request.form['rank_quality'])
        print(str(rank_quality))
        rank_taste = json.loads(request.form['rank_taste'])
        print(str(rank_taste))
        all_company = json.loads(request.form['all_company'])
        print(str(all_company))
        all_group = json.loads(request.form['all_group'])
        print(str(all_group))
        for group in all_group:
            group_info = json.loads(group['info'])
            print(str(group_info))
            male_crab = json.loads(group['male_crab'])
            print(str(male_crab))
            female_crab = json.loads(group['female_crab'])
            print(str(female_crab))
            male_quality = json.loads(group['male_quality'])
            print(str(male_quality))
            female_quality = json.loads(group['female_quality'])
            print(str(female_quality))
            male_taste = json.loads(group['male_taste'])
            print(str(male_taste))
            female_taste = json.loads(group['female_taste'])
            print(str(female_taste))
        return "generate excel"
