import React from 'react';
import { StyleSheet,View, Text, Button,AsyncStorage,Alert,
  ActivityIndicator,FlatList,TouchableWithoutFeedback ,
ToastAndroid} from 'react-native';
import { List, ListItem } from 'react-native-elements';
export class StyledList extends React.Component {

    static navigationOptions = {
        title:'StyledList',
        headerStyle: {
          backgroundColor: 'green'
        },
        headerTitleStyle: {
          color: 'white'
        },
        headerTintColor: 'white',
       };

       constructor(props)
    {
      super(props);
      this.state = {isListLoaded :false,
                  infoList:null };
    }

    
    componentDidMount(){
        return fetch("https://www.androidbegin.com/tutorial/jsonparsetutorial.txt")
        .then((response) => response.json())
        .then((responseJson)=>{
             this.setState({
                 isListLoaded:true,
                 infoList:responseJson.worldpopulation
           })
  
        })
        .catch((error)=>{
          console.log(error);
        });
     }


     actionOnRow(item,index) {
        console.log('Selected Item :',item);
        Alert.alert("Clicked Item:::"+index+""+item.country);
       // ToastAndroid.show(""+item.i,ToastAndroid.short);
     }
  

     render(){
        if(!this.state.isListLoaded){
            return(
               <View style={styles.container}>
                   <ActivityIndicator></ActivityIndicator>
               </View>
            );
        }else{
            return(
            <View style={styles.container}>
            <List>
            <FlatList 
            data = {this.state.infoList}
            keyExtractor={(item,index)=>item.index}
            renderItem = {({item,index})=>
            <ListItem onPress={ () => this.actionOnRow(item,index)}>
            roundAvatar
            avatar={{uri:item.flag}}
            title={item.country}
            subtitle={item.population}
            </ListItem>
            }
            >
           </FlatList>
            </List>
            </View>

            );
        }
     };
}


const styles = StyleSheet.create({
    container: {
      felx:1,
      margin:10
      }
  });