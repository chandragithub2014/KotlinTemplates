import React from 'react';
import { StyleSheet,View, Text, Button,AsyncStorage,Alert,
    ActivityIndicator,FlatList,TouchableWithoutFeedback ,
  ToastAndroid} from 'react-native';
  import dbOperations from '../data/dbOperations';
  var service = new dbOperations();
  export class DBList extends React.Component{
    
    constructor(props) {
        super(props)
        this.state = {
          records: []
        }
       service.init()
      }
    
      async componentWillMount(){
        var result = await service.select("profile")
        this.setState({
          records: result
        })
      }

      render() {
        return (
          <View style={styles.container}>
            <FlatList
              data={this.state.records}
              renderItem={({ item ,index}) => <Text>{item.firstname}</Text>}
              keyExtractor={(item,index)=>item.index}
            />
          </View>
        );
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