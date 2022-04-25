import React from 'react';
import {View, Text, Button, StyleSheet} from 'react-native';

import NavBar from '../../components/appbar';
import CustomBack from '../../components/appbar';

const theme = useTheme();

export const DetailsScreen = () => {
  return (
    <View style={style.container}>
      <CustomBack />
      <Text>Details Screen</Text>
    </View>
  );
}

const HomeScreen = () => {
  return (
    <View style={style.container}>
      <NavBar />
      <Button
        title="Go to details"
        onPress={() => navigation.navigate('Details')}
      />
    </View>
  );
}

const style = StyleSheet.create({
    container: {
      flex: 1,
      alignItems: 'center',
      justifyContent: 'center',
    }
})

export default HomeScreen;
