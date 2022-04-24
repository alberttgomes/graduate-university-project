import React from 'react';

import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import Home from '../Pages/Login/index';
import Login from '../Pages/Home/index';

const Stack = createNativeStackNavigator();

const Routes = () => {
  return (
     <NavigationContainer>
        <Stack.Navigator initialRouteName="Home">
          <Stack.Screen name="Login" component={Login} /> 
          <Stack.Screen name="Home" component={Home} />
        </Stack.Navigator>
     </NavigationContainer>
  );
}

export default Routes;