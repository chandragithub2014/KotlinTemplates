import React,{Component} from 'react';
import { StyleSheet,
    Text,
      View,
        TextInput,
            TouchableHighlight,
                Alert,
                   AsyncStorage} from 'react-native';

export class InformationList extends Component{

  /*      constructor(props){
            super(props);
            this.state = {isListLoaded :false,
                        infoList:null };
        }
*/
    /*   componentDidMount(){
            return fetch("https://jsonplaceholder.typicode.com/posts")
            .then((response) => response.json())
            .then((responseJson)=>{
                 this.setState({
                     isListLoaded:true,
                     infoList:responseJson
                 })

            })
            .catch((error)=>{
              console.log(error);
            });
        }

*/
  /*      render(){
            if(!this.state.isListLoaded){
                return(
                   <View style={styles.container}>
                       <ActivityIndicator></ActivityIndicator>
                   </View>
                );
            }else{
                return(
                    <View style={styles.container}>
                    <Text>Content Loaded.....</Text>
                </View>

                );
            }
        }
*/
        render(){
            return(
                <View style={styles.container}>
                <Text>Content Loaded.....</Text>
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