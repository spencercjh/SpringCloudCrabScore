import logging
import os
import smtplib
import sys
import traceback
from email.header import Header
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.utils import formataddr

curPath = os.path.abspath(os.path.dirname(__file__))
rootPath = os.path.split(curPath)[0]
sys.path.append(rootPath)
from src.util.config_util import config

config = config.get_config()
LOG_FORMAT = ('%(levelname) -10s %(asctime)s %(name) -30s %(funcName) '
              '-35s %(lineno) -5d: %(message)s')
logging.basicConfig(level=logging.DEBUG, format=LOG_FORMAT)
LOGGER = logging.getLogger("excel")


def send_mail(receivers: list, file_path: str, file_name: str):
    message = MIMEMultipart()
    message['From'] = formataddr([config['from'], config['mail_sender']])
    message['To'] = Header(config['to'], 'utf-8')
    subject = config['subject']
    message['Subject'] = Header(subject, 'utf-8')
    message.attach(MIMEText(config['message'], 'plain', 'utf-8'))
    attachment = MIMEText(open(file_path, 'rb').read(), 'base64', 'utf-8')
    attachment["Content-Type"] = 'application/octet-stream'
    attachment["Content-Disposition"] = 'attachment; filename="%s"' % file_name
    message.attach(attachment)
    server = smtplib.SMTP_SSL(config['mail_host'], config['mail_port'])
    try:
        server.login(config['mail_user'], config['mail_pass'])
        server.sendmail(config['mail_sender'], receivers, message.as_string())
        LOGGER.debug("邮件发送成功")
    except smtplib.SMTPException:
        traceback.print_exc()
        LOGGER.error("Error: 无法发送邮件")
    finally:
        server.quit()
