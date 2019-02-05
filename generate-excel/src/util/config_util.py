import datetime
import json
import os

import pymysql
import requests
import yaml


class Config(object):
    def __init__(self):
        self.conf_path = os.path.abspath(
            os.path.dirname(__file__)) + "/config.yaml"

    def get_config(self):
        if not os.path.isfile(self.conf_path):
            print(self.conf_path)
            print("config not found")
            exit(1)
        with open(self.conf_path, 'r') as stream:
            try:
                return yaml.load(stream)
            except yaml.YAMLError as exc:
                print(exc)
                exit(1)

    def set_conf_path(self, conf_path):
        self.conf_path = conf_path

    @staticmethod
    def sc_ftqq_send_message(text, desp):
        config = Config().get_config()
        sc_url = config['sc_url']
        url = sc_url + "?text=%s" % text + "&desp=%s" % desp
        return requests.request(method="GET", url=url)

    @staticmethod
    def get_mysql_cursor():
        config = Config().get_config()
        host = config['mysql']['host']
        port = config['mysql']['port']
        user = config['mysql']['user']
        passwd = config['mysql']['passwd']
        charset = config['mysql']['charset']
        conn = pymysql.connect(host=host, port=port, user=user, password=str(passwd), charset=charset)
        conn.autocommit(1)
        cursor = conn.cursor()
        return cursor


config = Config()


class DateEncoder(json.JSONEncoder):
    def default(self, obj):
        if isinstance(obj, datetime.datetime):
            return obj.strftime('%Y-%m-%d %H:%M:%S')
        elif isinstance(obj, datetime.date):
            return obj.strftime("%Y-%m-%d")
        else:
            return json.JSONEncoder.default(self, obj)
