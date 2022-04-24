import React from "react";
import ClayNav from '@clayui/nav';

const NavBar = () => {
    <ClayNav>
        <ClayNav.Item>
            <ClayNav.Link active href="#">{"Placa Mãe"}</ClayNav.Link>
        </ClayNav.Item>
        <ClayNav.Item className="ml-5">
            <ClayNav.Link href="#">{"Material"}</ClayNav.Link>
        </ClayNav.Item>
        <ClayNav.Item className="ml-5">
            <ClayNav.Link href="#">{"Quiz"}</ClayNav.Link>
        </ClayNav.Item>
  </ClayNav>
}

export default NavBar();