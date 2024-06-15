import sqlite3

con = sqlite3.connect(':memory:')
cur = con.cursor()

cur.execute('CREATE TABLE mytable(col1, col2, col3)')
