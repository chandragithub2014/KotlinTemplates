import React from 'react';
import { StyleSheet,
  Text,
    View,
      TextInput,
          TouchableHighlight,
              Alert,
                 AsyncStorage, Button } from 'react-native';
import { StackNavigator } from 'react-navigation';
import {NavDrawer} from './NavDrawer';


export class Login extends React.Component {
    static navigationOptions = {
        header: null
        };
  
  
        constructor(props){
          super(props);
          this.state = {
             userName:'',
             passwrd:''
          };
       
      }

     _loginAccount = ()=>{
          if(!this.state.userName){
              Alert.alert('please enter userName');
          }else if(!this.state.passwrd){
            Alert.alert('please enter PassWord');
          }else{
          //  Alert.alert("Login success");
          //  this.props.navigation.navigate('ListInfo');
          this.props.navigation.navigate('TabScreenMain');
         //  this.props.navigation.navigate('NavDrawer');
          }
      };
     
     
        
  render() {
    return (
      <View style={styles.container}>
                 <Text style={styles.titleText}>Login</Text>
                 <Text style={styles.basicText}>Enter UserName</Text>
                 <TextInput 
                            style={styles.inputText}
                             onChangeText={(text) => this.setState({userName: text})}
                             value={this.state.userName}></TextInput>
                 <Text style={styles.basicText}>Enter PassWord</Text>
                 <TextInput  placeholder = "Enter Password"
                             secureTextEntry 
                             style={styles.inputText}
                             onChangeText={(text) => this.setState({passwrd: text})}
                             value={this.state.passwrd}
                           ></TextInput>  
                  <TouchableHighlight
                     onPress={ () => this._loginAccount() }
                     underlayColor="white">
                     <View style={styles.button}>
                      <Text style= {styles.buttonText}>Login</Text>
                      </View>
                      </TouchableHighlight>              

             </View>
     /* <View>
        <Text>This is the Login screen</Text>
        <Button onPress={() => this.props.navigation.navigate('ListInfo')} title='Click to go to page 2' />
      </View>*/
    )
  }
};

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
      fontSize: 30,
      fontWeight: 'bold',
      color: '#2196F3',
      textAlign: 'center'
    },
    basicText: {
      fontSize: 20,
      fontWeight: 'normal',
      paddingBottom:10
    },
    inputText:{
      borderBottomColor: '#000000',
      borderBottomWidth: 1,
      fontSize: 20,
      fontWeight: 'normal',
      marginBottom:5
    }
});
//export default Login;