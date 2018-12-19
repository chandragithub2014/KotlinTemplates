import SQLite from 'react-native-sqlite-storage';
import WebSQLite from 'websqlite';

const SQLiteManager = new WebSQLite();

export default class dbOperations {

    init() {
        SQLiteManager.init({
            id: 'UserInfoDB',
            dbObject: SQLite,
        })
    }
    async  select ( tableName , columns , where ) {
        if (where) {
            var whereKey =  Object . keys (where) [ 0 ]
            var whereValue = where [whereKey]
            return  await  SQLiteManager . select (tableName, ((columns || columns ===  " " ) ?  " * "  : columns), whereKey +  " =? " , [whereValue])
        }
        else {
            return  await  SQLiteManager . select (tableName, ((columns || columns ===  " " ) ?  " * "  : columns))
        }
    }

}