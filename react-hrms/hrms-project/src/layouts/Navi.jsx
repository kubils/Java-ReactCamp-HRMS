import React, { useState } from 'react'
import SiteLang from './SiteLang'
import { Menu } from 'semantic-ui-react'
import { Container } from 'semantic-ui-react'
import './css/Navi.css';
import { Link } from 'react-router-dom'

export default function Navi() {


    return (
        <div>
            {/* <CartSummary /> */}
            <Menu inverted fixed="top" size='small' className="main" tabular>

                <Container>
            
                    <Menu.Item
                        as={Link} to='/'
                    >
                         <img src ="https://res.cloudinary.com/dp3iwc0ug/image/upload/v1623713151/hrms_qo34te.png"   alt ="HRMS">
                    </img>

                     </Menu.Item>
                      
                    <Menu.Item>
                        <SiteLang />
                    </Menu.Item>

                    <Menu.Menu position='right'>

                        {/* CartSummary file import */}

                        <Menu.Item>

                            <div class="item">
                                <Link to={`/Register`} >
                                    <div class="ui primary button" size='small'>
                                        Sign up</div>
                                </Link>
                            </div>

                            <div class="item" >
                                <Link to={`/`} >
                                    <div class="ui button" id="log_id">Log-in</div>
                                </Link>

                            </div>
                        </Menu.Item>
                    </Menu.Menu>
                </Container>
            </Menu>

        </div>
    )
}
