/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';
import  { Login } from './infoscreens/Login';
import  { ListInfo } from './infoscreens/ListInfo';
import {ListDetail} from './infoscreens/ListDetail';
import {Settings} from './infoscreens/Settings';
import {StartUpList} from './infoscreens/StartUpList';
import {StyledList} from './infoscreens/StyledList';
import {createMaterialTopTabNavigator} from 'react-navigation';


//import { createStackNavigator, createAppContainer } from 'react-navigation';
import {StackNavigator} from 'react-navigation';



const App = StackNavigator({
Login: { screen: Login },
ListInfo: { screen: ListInfo },
ListDetail: { screen: ListDetail },
StartUpList:{screen: StartUpList},
StyledList:{screen: StyledList},
TabScreenMain:{
  screen : createMaterialTopTabNavigator(
  {
    Home:ListInfo,
    Setting: Settings

 })
},
},
{
initialRouteName: 'Login'
}
);

export default App;



/*
const RootStack = createStackNavigator(
  {
    Login: {
      screen: Login,
    },
    ListInfo: {
      screen: ListInfo,
    },
  },
  {
    initialRouteName: 'Login',
  }
);


export default class App extends Component {
  render() {
    return (
      <View>
        <Text>This is the Login screen</Text>
      </View>
    );
  }
}

*/
