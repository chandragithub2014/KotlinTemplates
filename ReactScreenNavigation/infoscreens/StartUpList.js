import React from 'react';
import { StyleSheet,View, Text, Button,AsyncStorage,Alert,
  ActivityIndicator,FlatList,TouchableWithoutFeedback ,
ToastAndroid} from 'react-native';
import listData from '../data/listData';
/*
class ListItemInfo extends React.Component{
    render(){
        return(
            <TouchableWithoutFeedback onPress={ () => this.actionOnRow(item,index)}>
            <View style={styles.listItemStyle}>
            <Text style={styles.titleText}>listInfooooo</Text>
          </View> 
             </TouchableWithoutFeedback>
        );
    }

    
}*/
export class StartUpList extends React.Component {
    static navigationOptions = {
        title:'Landing List',
        headerStyle: {
          backgroundColor: 'green'
        },
        headerTitleStyle: {
          color: 'white'
        },
        headerTintColor: 'white',
       };
  
       actionOnRow(item,index) {
        console.log('Selected Item :',item);
        Alert.alert("Clicked Item:::"+index);
        if(index ==0){
          this.props.navigation.navigate('ListInfo');
        }else if(index==1){
          this.props.navigation.navigate('TabScreenMain');
        }else if(index==2){
          this.props.navigation.navigate('StyledList');
        }
     }
    render(){
        return(
            <View style={styles.container}>
            <FlatList 
               data = {listData}
               renderItem = {({item,index})=>
               <TouchableWithoutFeedback onPress={ () => this.actionOnRow(item,index)}>
               <View style={styles.listItemStyle}>
               <Text style={styles.basicText}>{item.name}</Text>
               </View> 
                </TouchableWithoutFeedback>
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
      margin:10,
      flex:1,
      alignItems:'center',
      justifyContent:'center'
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
        marginLeft:5,
        textAlign: 'center',
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
        flex:1,
        borderWidth: 1,
        margin:5
  
      },
      headerStyles:{
          backgroundColor: '#00FF00',
          color: '#FFFFFF',
          fontFamily: "Lato-Regular",
      }
  });