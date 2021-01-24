import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

import Start from './components/Start'
import Bookinfo from './components/Bookinfo'
import Splash from './components/SplashScreen';


const Stack = createStackNavigator();
const startstack = () => {

    
  return (
  <NavigationContainer>

  <Stack.Navigator initialRouteName="Splash">

  <Stack.Screen
  name="Splash"
  component={Splash}
  options={{ title: 'Welcome', headerLeft : null }}
  />

  <Stack.Screen
  name="Home"
  component={Start}
  options={{ title: 'Book Store', headerLeft : null }}
  />

  <Stack.Screen
  name="Details"
  component={Bookinfo}
  options={{ title: 'Book Details' }}
  />

  </Stack.Navigator>
  </NavigationContainer>
  );
};

export default startstack;