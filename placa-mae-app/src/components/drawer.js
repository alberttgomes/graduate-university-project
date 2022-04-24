import React from 'react';
import { useWindowDimensions } from 'react-native';

import { createDrawerNavigator } from '@react-navigation/drawer';

import Home from '../Pages/Home';
import Login from '../Pages/Login';

const Drawer = createDrawerNavigator();

const DrawerBar = () => {
  const dimensions = useWindowDimensions();
  
  const isLargeScreen = dimensions.width >= 768;

  return (
    <Drawer.Navigator
        screenOptions={{
            drawerType: isLargeScreen ? 'permanent' : 'front',
            drawerStyle: isLargeScreen ? null : { width: '100%' },
            overlayColor: 'transparent',
        }}
    >
      <Drawer.Screen name='Home' component={Home} />
      <Drawer.Screen name='Login' component={Login} />
    </Drawer.Navigator>
  );
}

export default DrawerBar;