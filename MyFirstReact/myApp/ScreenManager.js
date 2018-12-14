import React,{Component} from 'react';
import { StackNavigator } from 'react-navigation';
import { StyleSheet,
            Text,
              View,
                TextInput,
                    TouchableHighlight,
                        Alert,
                           AsyncStorage} from 'react-native';
 import LoginScreen from './myViews/Login';
 import InfoListScreen from './infoList/InformationList';     
 
 const Screens = StackNavigator({
  LoginScreen:{screen:LoginScreen},
  InfoListScreen:{screen:InfoListScreen}
 });

 export default Screens;