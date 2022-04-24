import { createDrawerNavigator } from '@react-navigation/drawer';

import Home from '../Pages/Home';
import Login from '../Pages/Login';

const Drawer = createDrawerNavigator();

const DrawerBar = () => {
  return (
    <Drawer.Navigator>
      <Drawer.Screen name='Home' component={Home} />
      <Drawer.Screen name='Login' component={Login} />
    </Drawer.Navigator>
  );
}

export default DrawerBar;