import os

import pymysql
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
        with open(self.conf_path, 'r', encoding='utf-8') as stream:
            try:
                return yaml.load(stream, Loader=yaml.SafeLoader)
            except yaml.YAMLError as exc:
                print(exc)
                exit(1)

    def set_conf_path(self, conf_path):
        self.conf_path = conf_path

    @staticmethod
    def get_mysql_cursor():
        config = Config().get_config()
        host = config['mysql']['host']
        port = config['mysql']['port']
        user = config['mysql']['user']
        password = config['mysql']['password']
        charset = config['mysql']['charset']
        conn = pymysql.connect(host=host, port=port, user=user, password=str(password), charset=charset)
        conn.autocommit(1)
        # 需要列名方便数据处理
        cursor = conn.cursor(pymysql.cursors.DictCursor)
        cursor.execute('use rxpbdb')
        return cursor


config = Config()
