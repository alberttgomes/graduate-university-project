import React from 'react'
import { Appbar } from 'react-native-paper';
import { StyleSheet } from 'react-native';

import { NavigationContainer } from '@react-navigation/native';

import Routes from './Routes';



const Navigation = () => {
  <NavigationContainer>
     <Appbar style={styles.bottom}>
         <Routes />
     </Appbar>
  </NavigationContainer>
};

const styles = StyleSheet.create({
    bottom: {
      position: 'absolute',
      left: 0,
      right: 0,
      bottom: 0,
    },
});

export default Navigation;
