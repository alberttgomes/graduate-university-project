import React from 'react';
import { View, Text } from 'react-native';
import { DefaultTheme, Divider, Provider as PaperProvider } from 'react-native-paper';
import { Appearance } from 'react-native';

import Navigation from './src/components/Menu';

const light = {
  ...DefaultTheme,
  roundness:2,
  colors:{
    ...DefaultTheme.colors,
    background: '#FFF',
    primary: '#131313',
    accent: '#9B0054',
    danger: '#Ed1c24'
  }
};


const dark = {
  ...DefaultTheme,
  roundness:2,
  colors:{
    ...DefaultTheme.colors,
    background: '#131313',
    primary: '#FFF',
    accent: '#9B0054',
    danger: '#Ed1c24'
  }
};

const colorScheme = Appearance.getColorScheme();

export default function App() {
  console.log(colorScheme);
  return(
    <PaperProvider theme={colorScheme === 'dark' ? dark : light}>
       <View>
         <Text style={{fontSize:30, fontWeight:'bold'}}>Go Thoughts</Text>
       </View>
       <Divider />
       <Navigation />
    </PaperProvider>
  );
}
