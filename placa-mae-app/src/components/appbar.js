import React from 'react';
import { useTheme, Appbar } from 'react-native-paper';

export const CustomBack = ({ navigation, back }) => {
    return (
      <Appbar.Header>
        {back ? <Appbar.BackAction onPress={navigation.goBack} /> : null}
        <Appbar.Content title="Placa Mãe" />
      </Appbar.Header>
    );
}

const NavBar = ({ navigation, back }) => {
    const [visible, setVisible] = React.useState(false);
    
    const openMenu = () => setVisible(true);
    
    const closeMenu = () => setVisible(false);

    return (
        <Appbar.Header>
            {back ? <Appbar.BackAction onPress={navigation.goBack} /> : null}
        <Appbar.Content title="Placa Mãe" />
            {!back ? (
                <Menu
                    visible={visible}
                    onDismiss={closeMenu}
                    anchor={
                        <Appbar.Action icon="menu" color="white" onPress={openMenu} />
                    }
                >
                    <Menu.Item onPress={() => {console.log('Material')}} title="Material" />
                    <Menu.Item onPress={() => {console.log('Quiz')}} title="Quiz" />
                    <Menu.Item onPress={() => {console.log('Denúncia')}} title="Denúncia" disabled />
                </Menu>
        ) : null}
        </Appbar.Header>
    );
};

export default NavBar;