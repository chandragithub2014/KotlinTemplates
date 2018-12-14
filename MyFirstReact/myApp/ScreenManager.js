import React,{Component} from 'react';
import { StackNavigator } from 'react-navigation';
import { StyleSheet,
            Text,
              View,
                TextInput,
                    TouchableHighlight,
                        Alert,
                           AsyncStorage} from 'react-native';
 import LoginScreen, { Login } from './myViews/Login';
 import InfoListScreen, { InformationList } from './infoList/InformationList';    
 import { createStackNavigator, createAppContainer } from "react-navigation"; 
 
 /*const Screens = StackNavigator({
  LoginScreen:{screen:LoginScreen},
  InfoListScreen:{screen:InfoListScreen}
 });*/

 const AppNavigator = createStackNavigator(
  {
    Home: Login,
    LoginChild: InformationList
  },
  {
    initialRouteName: "Home"
  }
);

export default createAppContainer(AppNavigator);
 //export default Screens;