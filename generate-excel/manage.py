# manage.py
import os
import subprocess
import sys
import unittest

import coverage
from flask.cli import FlaskGroup
from gevent.pywsgi import WSGIServer

curPath = os.path.abspath(os.path.dirname(__file__))
rootPath = os.path.split(curPath)[0]
sys.path.append(rootPath)
from src import create_app

app = create_app()
cli = FlaskGroup(create_app=create_app)


@cli.command()
def server():
    try:
        http_server = WSGIServer(('', 5000), app)
        print("FLASK BEGIN:listening on 5000")
        http_server.serve_forever()
    except KeyboardInterrupt:
        print("quit")
        sys.exit(1)


# code coverage
COV = coverage.coverage(
    branch=True,
    include='src/*',
    omit=[
        'src/tests/*',
        'src/util/*'
    ]
)
COV.start()


@cli.command()
def test():
    """Runs the unit tests without test coverage."""
    tests = unittest.TestLoader().discover('src/test', pattern='test*.py')
    result = unittest.TextTestRunner(verbosity=2).run(tests)
    if result.wasSuccessful():
        sys.exit(0)
    else:
        sys.exit(1)


@cli.command()
def cov():
    """Runs the unit tests with coverage."""
    tests = unittest.TestLoader().discover('src/test')
    result = unittest.TextTestRunner(verbosity=2).run(tests)
    if result.wasSuccessful():
        COV.stop()
        COV.save()
        print('Coverage Summary:')
        COV.report()
        COV.html_report()
        COV.erase()
        sys.exit(0)
    else:
        sys.exit(1)


@cli.command()
def flake():
    """Runs flake8 on the project."""
    subprocess.run(['flake8', 'src'])


if __name__ == '__main__':
    cli()
