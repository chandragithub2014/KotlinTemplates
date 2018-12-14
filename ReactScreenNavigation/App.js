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
//import { createStackNavigator, createAppContainer } from 'react-navigation';
import {StackNavigator} from 'react-navigation';



const App = StackNavigator({
Login: { screen: Login },
ListInfo: { screen: ListInfo },
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
