/*jshint esversion: 6 */
import React,{Component} from 'react';
import { StyleSheet,
            Text,
              View,
                TextInput,
                    TouchableHighlight,
                        Alert,
                           AsyncStorage} from 'react-native';

export class Login extends React.Component{

   constructor(props){
       super(props);
       this.state = {
          userName:'',
          passwrd:''
       };
     //  this._loginAccount = this._loginAccount.bind(this);
   }

    _loginAccount = ()=>{
      if(!this.state.userName){
          Alert.alert('please enter userName');
      }
   };

   _displayInfo = ()=>{
    console.log("Clicked Login");
    Alert.alert("Clicked Login");
   };

   /*loginAccount(){
    if(!this.state.userName){
      Alert('please enter userName');
  }
   }*/

    render(){
        return(
             <View style={styles.container}>
                 <Text style={styles.titleText}>Login</Text>
                 <Text style={styles.basicText}>Enter UserName</Text>
                 <TextInput placeholder="Enter UserName" 
                            style={styles.inputText}
                             onChangeText={(text) => this.setState({userName: text})}
                             value={this.state.userName}></TextInput>
                 <Text style={styles.basicText}>Enter PassWord</Text>
                 <TextInput placeholder="Enter PassWord"
                             secureTextEntry={true}
                             style={styles.inputText}
                             value={this.state.passwrd}
                             onChangeText={(text) => this.setState({passwrd: text})}>
                             ></TextInput>  
                  <TouchableHighlight
                     onPress={this._loginAccount} 
                     underlayColor="white">
                     <View style={styles.button}>
                      <Text style= {styles.buttonText}>Login</Text>
                      </View>
                      </TouchableHighlight>              

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
