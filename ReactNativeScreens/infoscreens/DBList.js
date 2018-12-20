import React from 'react';
import { Platform,StyleSheet,View, Text, Button,AsyncStorage,Alert,
    ActivityIndicator,FlatList,TouchableWithoutFeedback ,
  ToastAndroid} from 'react-native';
  import dbOperations from '../data/dbOperations';
  // service = new dbOperations();
  var SQLite = require('react-native-sqlite-storage')
 
  export class DBList extends React.Component{
    
    constructor(props) {
        super(props)
        this.state = {
          records: null,isListLoaded :false
        }
        let db = SQLite.openDatabase({name: 'test.db', createFromLocation: '~UserInfoDB.db',
        location: 'Library'},this.openCB, this.errorCB)
        db.transaction((tx) => {
          tx.executeSql('SELECT * FROM profile', [], (tx, results) => {
              console.log("Query completed");
             
    
              // Get rows with Web SQL Database spec compliance.
    
              var len = results.rows.length;
           //   Alert.alert("Length::::"+len);
              for (let i = 0; i < len; i++) {
                let row = results.rows.item(i);
             //   console.log(`Record: ${row.firstname}`);
               // isListLoaded = true;
                this.setState({records: row,isListLoaded:true});
              }
            });
        });
    
      
      }
      errorCB(err) {
        console.log("SQL Error: " + err);
      }
    
      successCB() {
        console.log("SQL executed fine");
      }
    
      openCB() {
        console.log("Database OPENED");
      }
      

      render() {
        if(!this.state.isListLoaded ){
          return(
             <View style={styles.container}>
                 <ActivityIndicator></ActivityIndicator>
             </View>
          );
      }else{
        return (
          <View style={styles.container}>
            <FlatList
              data={this.state.records}
              renderItem={({ item ,index}) => 
              <View>
              <Text>{item.firstname}</Text>
              <Text>Hello</Text>
              </View>
               }
              keyExtractor={(item,index)=>item.index}
            />
          </View>
        );
      }
      }
    
  }

  const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: 'center',
      alignItems: 'center',
      backgroundColor: '#F5FCFF',
    },
    welcome: {
      fontSize: 20,
      textAlign: 'center',
      margin: 10,
    },
    instructions: {
      textAlign: 'center',
      color: '#333333',
      marginBottom: 5,
    },
  });