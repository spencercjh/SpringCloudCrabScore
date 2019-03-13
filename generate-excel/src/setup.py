from setuptools import setup

setup(
    name='generate-excel',
    version='1',
    packages=['', 'util'],
    package_dir={'': 'src'},
    url='https://www.sepncercjh.top',
    license='Artistic License 2.0',
    author='spencercjh',
    author_email='shouspencercjh@foxmail.com',
    description='excel output service for crabscore',
    install_requires=['xlwt', 'flask', 'pymysql', 'PyYAML', 'coverage', 'gevent']

)
