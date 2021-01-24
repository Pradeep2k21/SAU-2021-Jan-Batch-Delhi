import React, { Component } from 'react';
import { View,Text, Image,Dimensions, Button,Linking } from 'react-native';
import { TouchableOpacity } from 'react-native-gesture-handler';

export default class Details  extends Component{

    
    constructor(props)
    {
        super(props);
        this.state = {
            name : props.route.params.itemTitle,
            itemImage : props.route.params.itemImage
        };
    }
    
    render()
    {
        
        return(
            <View>
                
                <Image source = {{uri: this.state.itemImage}} style={{height:500,width:500}}/>
                <Button title="Click me" onPress={()=> alert(this.state.name)}></Button>

                <TouchableOpacity style={{backgroundColor:'green',padding:10}}
                onPress={()=>Linking.openURL('https://www.accolite.com/')}>
                    <Text style={{textAlign:'center',fontSize:20,fontWeight:'bold'}}>View Details</Text>
                </TouchableOpacity>

            </View>
        );
    }
} 