import React, {useContext} from "react";
import { Text, View } from 'react-native';

import { Avatar, Button, Card, Divider, useTheme } from "react-native-paper"

import { useNavigation } from "@react-navigation/native";

import {AuthContext} from '../../contexts/auth';


export default function Home() {
    const navigation = useNavigation();

    const { user } = useContext(AuthContext);

    const { colors } = useTheme();

    return (
      <View style={{flex:1, justifyContent:'center', alignItems:'center', backgroundColor: colors.background}}>
          <Card>
              <Avatar>
                  
              </Avatar>
              <Text>Welcome: {user.email} </Text>
          </Card>
            <Divider />
          <Text style={{fontSize: 25, color:colors.primary}}>Placa Mae</Text>
          <Text style={{fontSize: 25, color:colors.accent}}>Quiz</Text>

          <Button
            title=""
            mode="text"
            icon="camera"
            color={colors.danger}
          >
             Material
          </Button>
      </View>
  );
}

