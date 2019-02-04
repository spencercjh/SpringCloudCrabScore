import json
import platform

from excel import save_excel_book, sheet_all_company, sheet_rank_fatness, sheet_rank_quality, sheet_rank_taste, sheet_quality_score, \
    sheet_taste_score, sheet_fatness_score
from flask import request, Flask, render_template

app = Flask(__name__, template_folder='../templates')


# noinspection PyUnresolvedReferences
@app.route('/')
def home():
    return render_template('home.html')


@app.route('/generate', methods=['POST'])
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


if __name__ == '__main__':
    if 'WindowsPE' in platform.architecture():
        app.run(host="127.0.0.1", port=5000)
    else:
        app.run(host="0.0.0.0", port=5000)
