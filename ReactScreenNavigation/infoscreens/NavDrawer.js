import React from 'react';
import { StyleSheet,View, Text, Button,AsyncStorage,Alert,
  ActivityIndicator,FlatList,TouchableWithoutFeedback ,
ToastAndroid} from 'react-native';
import {CreateDrawerNavigator,StackNavigator ,DrawerItems} from 'react-navigation';
import  { ListInfo } from './ListInfo';
import {Settings} from './Settings';

/*
const App = CreateDrawerNavigator({
  ListInfo: { screen: ListInfo},
  Settings: { screen: Settings}
})
*/

export class NavDrawer extends React.Component {
  static navigationOptions = {
    header: null
    };
     render(){
          return(
           <View><Text>NavDrawer......</Text></View>
          );
    }

}
/*
const AppDrawerNavigator = CreateDrawerNavigator(
  {
    Home:ListInfo,
    Setting: Settings
 }
);*/
/*
const AppDrawerNavigator = CreateDrawerNavigator(
  {
    Home:ListInfo,
    Setting: Settings
},
{
  intialRouteName: 'Home',
  navigationOptions: {
    headerStyle : {
      backgroundColor: '#f4511e',
    },
    headerTintColor: '#fff',
    headerTitleStyle : {
      color: 'white',
      },
     },
   }
);
const AppStack = StackNavigator({ AppDrawerNavigator : { screen: AppDrawerNavigator } });

const styles = StyleSheet.create({
    container: {
      flex:1,  
      paddingTop: '10%',
      margin:10,
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
  });*/