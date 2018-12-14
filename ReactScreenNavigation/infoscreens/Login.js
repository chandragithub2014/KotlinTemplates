import React from 'react';
import { View, Text, Button } from 'react-native';
import { StackNavigator } from 'react-navigation';

export class Login extends React.Component {
    static navigationOptions = {
        header: null
        };
        
  render() {
    return (
      <View>
        <Text>This is the Login screen</Text>
        <Button onPress={() => this.props.navigation.navigate('ListInfo')} title='Click to go to page 2' />
      </View>
    )
  }
};

//export default Login;