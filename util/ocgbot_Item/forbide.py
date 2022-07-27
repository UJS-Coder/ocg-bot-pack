import random

import mysql.connector
from requests_html import HTMLSession

session = HTMLSession()
url = "https://www.ourocg.cn/Limit-Latest"
mydb = mysql.connector.connect(
    host="localhost",  # 默认用主机名
    user="root",  # 默认用户名
    password="Insectcs123",  # mysql密码
    charset='utf8',  # 编码方式
    database="ocgcardlocal",
    auth_plugin="mysql_native_password"
)
card_id_url = "#app > div.main > div > div.main-wrapper > div > div > div > div > div > article > div.card.el-row > div:nth-child(15)"
bans_url = "#app > div.main > div > div.main-wrapper > article > div.deckView > table > tbody:nth-child(2)"
rests_url = "#app > div.main > div > div.main-wrapper > article > div.deckView > table > tbody:nth-child(4)"
pres_url = "#app > div.main > div > div.main-wrapper > article > div.deckView > table > tbody:nth-child(6)"

# 禁止卡url
bans = []
# 限制卡url
rests = []
# 准限制卡url
pres = []


def urlGet():
    global bans, rests, pres
    r = session.get(url)
    bans = list(r.html.find(bans_url)[0].absolute_links)
    rests = list(r.html.find(rests_url)[0].absolute_links)
    pres = list(r.html.find(pres_url)[0].absolute_links)


def forbideUpdate(card_id):
    mycursor = mydb.cursor()
    sql = "SELECT name FROM ygo_card where card_id = " + card_id
    mycursor.execute(sql)
    myresult = mycursor.fetchone()
    return myresult


def insert(card_id, name, status):
    mycursor = mydb.cursor()
    sql = "insert into ygo_card_forbide(card_id,name,status) values (%s,%s,%s)"
    val = (str(card_id), str(name), str(status))
    mycursor.execute(sql, val)
    mydb.commit()


def init():
    urlGet()
    # for i in bans:
    #     re = session.get(i)
    #     card_id = re.html.find(card_id_url)[0].text
    #     name = forbideUpdate(card_id)[0]
    #     insert(card_id, name, "禁")
    # for i in rests:
    #     re = session.get(i)
    #     card_id = re.html.find(card_id_url)[0].text
    #     name = forbideUpdate(card_id)[0]
    #     insert(card_id, name, "限")
    # for i in pres:
    #     re = session.get(i)
    #     card_id = re.html.find(card_id_url)[0].text
    #     name = forbideUpdate(card_id)[0]
    #     insert(card_id, name, "准限")
    print(len(bans)+len(rests)+len(pres))

init()
