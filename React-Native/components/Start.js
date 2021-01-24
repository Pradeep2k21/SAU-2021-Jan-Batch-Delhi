import React, {Component} from 'react';
import { Searchbar } from 'react-native-paper';
import {Button,AppRegistry,SafeAreaView,StyleSheet, View, Text, FlatList,Image, TextInput, TouchableOpacity, ActionSheetIOS, ActivityIndicator} from 'react-native';

export default class Start extends Component {

  constructor(){
  super();
  this.state = {
  datafile : []
  }

  this.text = React.createRef();
 }

renderItem = ({item})=>{
  return(
    <View style={{flex:1,flexDirection : "column"}}>
      <Image style={{height:500,width:"100%"}} 
      source = {{uri : item.thumbnailUrl}}
      />
      <View style={styles.TextBoxDescriptions}>
     
      <Text style={{fontSize:25, fontWeight:"bold",marginVertical:"3"} }>{item.title}</Text>
      <Text style={{fontSize:25,fontWeight:"bold",marginVertical:"3"}}>{item.pageCount}</Text>
      </View>

      <TouchableOpacity style={styles.cssButton}
      onPress={()=> this.props.navigation.navigate('Details')}>
      <Text style={{textAlign:"center",fontSize:20,fontWeight:"bold"}}>Details</Text>
      </TouchableOpacity>
      </View>
  );
    
}

headerSearch = () => {
  return (
    <View style={styles.header}>
    <TextInput style={{height:50,width:550,borderWidth: 2,borderRadius:5,marginBottom:5,fontSize:20}}
       placeholder="Type Here..."
       ref = {this.text}
      />
      <TouchableOpacity style={{borderWidth:3,borderRadius:3,padding:10,borderColor:"black",shadowOpacity:0.2,shadowColor:"white"}}
      onPress = {() => {this.text.current.clear()}}>
      <Text style={{fontSize:20,fontWeight:"bold",color:"white"}}>X</Text>
      </TouchableOpacity>

      <TouchableOpacity style={{borderWidth:3,borderRadius:3,padding:10,borderColor:"black",shadowOpacity:0.2,shadowColor:"white"}}>
      <Text style={{fontSize:20,fontWeight:"bold",color:"white"}}>S</Text>
      </TouchableOpacity>
    </View>

  );
}



componentDidMount(){

  const url=" http://www.json-generator.com/api/json/get/cvXsjJsAMO?indent=2";
  fetch(url)
  .then((Response) => Response.json())
  .then((responseJson)=>{
    console.log("pradeep",responseJson.Books)
    this.setState({
        datafile: responseJson.Books
      })
  })

  .catch((error)=>{
    console.log(error)
  })
}

renderSeparator = () =>{
  return(
  <View style={styles.Renderseperate}>
  </View>
  );
  }


  

 render(){
   return (
    
     <View style={styles.container}>
          <FlatList 
                
                data={this.state.datafile}
                ListHeaderComponent={this.headerSearch}
                renderItem={this.renderItem}
                stickyHeaderIndices={[0]}
                keyExtractor={(item,index)=>item._id.toString()}
                ItemSeparatorComponent={this.renderSeparator}
          />
     </View>
     
   );
 }
}

const styles = StyleSheet.create({
  container: {
  
  backgroundColor: 'white',
  },
cssButton:
{
borderWidth:2,
borderColor:"black",
paddingVertical: 12,
borderRadius:5,
backgroundColor:"lightgreen",
elevation:0,
shadowOpacity:0.5,
shadowOffset:{width:3,height:5},
},

header: {
  flex: 1,
  flexDirection: "row",
  justifyContent: "space-between",
  marginTop: 5,
  flexWrap: "wrap",
  backgroundColor: 'rgba(0,0,0,0.5)',
  padding: 3
  },
TextBoxDescriptions:
{
marginVertical:5,
justifyContent:"space-around",
flexDirection:"row",
flexWrap:"wrap",
backgroundColor:"lightblue"
},
Renderseperate:{
  width:"100%",
  height:3,
  backgroundColor:"white",
  marginVertical:20,
  shadowOpacity:0.5,
  shadowOffset:{width:2,height:3}
},
crossAndsort:{
  textAlign: "center",
        fontSize: 30,
        fontWeight: "bold",
        color: 'red'
}
})