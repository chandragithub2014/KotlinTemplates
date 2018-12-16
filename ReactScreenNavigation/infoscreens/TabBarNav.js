import React from 'react';
import { StyleSheet,View, Text, Button,AsyncStorage,Alert,
    ActivityIndicator,FlatList,TouchableWithoutFeedback ,
  ToastAndroid} from 'react-native';
import {createBottomTabNavigator} from 'react-navigation';
import {createMaterialTopTabNavigator} from 'react-navigation';
import  { ListInfo } from './ListInfo';
import {Settings} from './Settings';

export class TabBarNav extends React.Component {
    static navigationOptions = {
        header: null
        };
    render(){
       return(
        <AppDrawerNavigator/>
       );
    }
}

const AppDrawerNavigator = createMaterialTopTabNavigator(
    {
      Home:ListInfo,
      Setting: Settings

   }
);
