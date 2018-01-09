<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>

    </head>
    <body>
        <form action="/build" method="post">
            <div>
                <label>
                    数据库地址：
                </label>
                <input name="dataBase.url" />
            </div>
            <div>
                <label>
                    数据库名字：
                </label>
                <input name="dataBase.dataBase" />
            </div>
            <div>
                <label>
                    表明：
                </label>
                <input name="tableName" />
            </div>
            <div>
                <label>
                    用户名：
                </label>
                <input name="dataBase.user" />
            </div>
            <div>
                <label>
                    密码：
                </label>
                <input name="dataBase.password" type="password"/>
            </div>
            <div>
                <label>
                    包名：
                </label>
                <input name="packag" />
            </div>
            <div>
                <button type="submit" value="提交"></button>
            </div>
        </form>
    </body>
</html>