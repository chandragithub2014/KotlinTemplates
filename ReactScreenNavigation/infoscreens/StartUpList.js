import React from 'react';
import { StyleSheet,View, Text, Button,AsyncStorage,Alert,
  ActivityIndicator,FlatList,TouchableWithoutFeedback ,
ToastAndroid} from 'react-native';
import {listData} from '../data/listData';

class ListItemInfo extends React.Component{
    render(){
        return(
            <TouchableWithoutFeedback onPress={ () => this.actionOnRow(item,index)}>
            <View style={styles.listItemStyle}>
            <Text style={styles.titleText}>{this.props.item.name}</Text>
          </View> 
             </TouchableWithoutFeedback>

        );
    }

    actionOnRow(item,index) {
        console.log('Selected Item :',item);
        Alert.alert("Clicked Item:::"+index);
    //    this.props.navigation.navigate('ListDetail',{selectedItemTitle:item.title});
       // ToastAndroid.show(""+item.i,ToastAndroid.short);
     }
}
export class StartUpList extends React.Component {
    static navigationOptions = {
        title:'ListInfo',
        headerStyle: {
          backgroundColor: 'green'
        },
        headerTitleStyle: {
          color: 'white'
        },
        headerTintColor: 'white',
       };
      
    render(){
        return(
            <View style={styles.container}>
            <FlatList 
               data = {listData}
               renderItem = {({item,index})=> {
                return(<ListItemInfo item = {item} index = {index}></ListItemInfo>);
              }
            }
            keyExtractor={(item,index)=>item.index}
              ></FlatList>
            </View>
        );
    }
}


const styles = StyleSheet.create({
    container: {
      paddingTop: '10%',
      margin:10
      },
    button: {
      marginBottom: 30,
      alignItems: 'center',
      backgroundColor: '#2196F3'
    },
    buttonText: {
      padding: 20,
      color: 'white',
      marginTop:10
      
    },
    titleText: {
        fontSize: 15,
        fontWeight: 'bold',
        color: '#2196F3',
        textAlign: 'left',
        marginLeft:5
  
      },
      basicText: {
        fontSize: 15,
        fontWeight: 'normal',
        paddingBottom:10,
        marginLeft:5
      },
      inputText:{
        borderBottomColor: '#000000',
        borderBottomWidth: 1,
        fontSize: 20,
        fontWeight: 'normal',
        marginBottom:5
      },
      listItemStyle:{
        borderColor: '#7a42f4',
        borderWidth: 1,
        margin:5
  
      },
      headerStyles:{
          backgroundColor: '#00FF00',
          color: '#FFFFFF',
          fontFamily: "Lato-Regular",
      }
  });