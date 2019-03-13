FROM python:3.6


RUN mkdir /app
WORKDIR /app
COPY . .
RUN python src/setup.py install

CMD python /app/src/manage.py server