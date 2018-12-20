import React from 'react';
import { StyleSheet,View, Text, Button,AsyncStorage,Alert,
  ActivityIndicator,FlatList,TouchableWithoutFeedback ,
ToastAndroid} from 'react-native';

export class Settings extends React.Component {
     render(){
          return(
           <View style={styles.container}>
               <Text>Settings Screen</Text>
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
  });