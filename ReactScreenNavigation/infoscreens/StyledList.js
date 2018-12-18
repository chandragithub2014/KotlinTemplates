import React from 'react';
import { StyleSheet,View, Text, Button,AsyncStorage,Alert,
  ActivityIndicator,FlatList,Image,TouchableWithoutFeedback ,
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
  
     renderItem = ({item,index})=>{
        <TouchableWithoutFeedback onPress={ () => this.actionOnRow(item,index)}>
      <View style = {styles.listItemStyle}>
          <Image style={styles.listItemImageStyle}
                 source={{uri:item.flag}}>
           </Image>
           <View style = {styles.listItemSubViewStyle}>
             <Text style={styles.listItemLabelStyle}>{item.country}</Text>
             <Text style={styles.listItemSubTitleStyle}>{item.population}</Text>
           </View>
      </View>
      </TouchableWithoutFeedback>
     }

     renderSeperator = ()=>{
        return(
        <View style={styles.listItemSepatorStyle}></View>
        );
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
             <View>
             <FlatList 
             data = {this.state.infoList}
             renderItem = {({item,index})=>
             <TouchableWithoutFeedback onPress={ () => this.actionOnRow(item,index)}>
             <View style = {styles.listItemStyle}>
             <Image style={styles.listItemImageStyle}
                    source={{uri:item.flag}}>
              </Image>
              <View style = {styles.listItemSubViewStyle}>
                <Text style={styles.listItemLabelStyle}>{item.country}</Text>
                <Text style={styles.listItemSubTitleStyle}>{item.population}</Text>
              </View>
         </View>
         </TouchableWithoutFeedback>
             } 
             keyExtractor={(item,index)=>item.index}
             ItemSeparatorComponent={this.renderSeperator}
             />
             </View>

            );
        }
     };
}

/*
<View style={styles.container}>
             <FlatList>
             data = {this.state.infoList}
             renderItem={this.renderItem}
             keyExtractor={(item,index)=>item.index}
             ItemSeparatorComponent={this.renderSeperator}
             </FlatList>
             </View>
*/ 
const styles = StyleSheet.create({
    container: {
      felx:1,
      margin:10
      },
      listItemStyle:{
          flex:1,
          flexDirection:'row',
          marginBottom:3
      },
      listItemImageStyle:{
          width:80,
          height:80,
          margin:5
      },
      listItemSubViewStyle:{
          flex:1,
          justifyContent:'center',
          marginLeft:5
      },
      listItemLabelStyle:{
         fontSize:18,
         color:'green',
         marginBottom:15
      },
      listItemSubTitleStyle:{
           color:'red',
           fontSize:16
      },
      listItemSepatorStyle:{
          width:'100%',
          height:1,
          backgroundColor:'black'
      }

  });