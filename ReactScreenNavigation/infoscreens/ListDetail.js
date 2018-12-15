import React from 'react';
import { StyleSheet,View, Text, Button,AsyncStorage,Alert,
  ActivityIndicator,FlatList,TouchableWithoutFeedback ,
ToastAndroid} from 'react-native';

export class ListDetail extends React.Component {
    static navigationOptions = {
        title:'ListDetail',
        headerStyle: {
          backgroundColor: 'green'
        },
        headerTitleStyle: {
          color: 'white'
        },
        headerTintColor: 'white',
       };

    constructor(props){
        super(props);
        this.state ={
          selectedItemInfo: this.props.navigation.state.params.selectedItemTitle,
        };
    }

    render(){
        return(
         <View>
         <Text>Selected Item:{this.state.selectedItemInfo}</Text>
         </View>
        

        );
    }

};