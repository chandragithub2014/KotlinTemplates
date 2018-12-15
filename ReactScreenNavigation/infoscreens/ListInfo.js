import React from 'react';
import { StyleSheet,View, Text, Button,AsyncStorage,Alert,
  ActivityIndicator,FlatList,TouchableWithoutFeedback ,
ToastAndroid} from 'react-native';

export class ListInfo extends React.Component {
  static navigationOptions = {
    title:'ListInfo',
    headerStyle: {
      backgroundColor: 'green'
    },
    headerTitleStyle: {
      color: 'white'
    },
    headerTintColor: 'white',
   };
    
    /* headerStyle: {
      backgroundColor: 'green'
    }, 
    */
    
    constructor(props)
    {
      super(props);
      this.state = {isListLoaded :false,
                  infoList:null };
    }

    componentDidMount(){
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
   actionOnRow(item,index) {
    console.log('Selected Item :',item);
    Alert.alert("Clicked Item:::"+index);
    this.props.navigation.navigate('ListDetail',{selectedItemTitle:item.title});
   // ToastAndroid.show(""+item.i,ToastAndroid.short);
 }

  render() {
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
         <FlatList 
          data = {this.state.infoList}
          renderItem = {({item,index})=>
          <TouchableWithoutFeedback onPress={ () => this.actionOnRow(item,index)}>
          <View style={styles.listItemStyle}>
          <Text style={styles.titleText}>{item.title}</Text>
           <Text style={styles.basicText}>{item.body}</Text>
           </View> 
           </TouchableWithoutFeedback>
          } 
          keyExtractor={(item,index)=>item.index}
         />
        </View>

      );
  }
   
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
/*
 return (
      <View>
        <Text>This is the List Info screen</Text>
      </View>
    )
*/
//export default ListInfo;