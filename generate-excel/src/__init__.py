import logging
import sys
import traceback

from flask import Flask, jsonify


def create_app(script_info=None):
    # instantiate the app
    app = Flask(
        __name__, template_folder='../templates'
    )

    # set config
    app.logger.setLevel(logging.INFO)

    from src.controller import excel_service
    app.register_blueprint(excel_service, url_prefix='/')

    @app.route('/healthcheck')
    def healthcheck():
        return jsonify("ok")

    # shell context for flask cli
    @app.shell_context_processor
    def ctx():
        return {'app': app}

    @app.errorhandler(Exception)
    def _error(error):
        trace = traceback.format_exc()
        status_code = getattr(error, 'status_code', 400)
        response_dict = dict(getattr(error, 'payload', None) or ())
        response_dict['message'] = str(error)
        response_dict['traceback'] = trace

        response = jsonify(response_dict)
        response.status_code = status_code
        traceback.print_exc(file=sys.stdout)
        return response

    return app
