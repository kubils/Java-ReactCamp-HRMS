import React from 'react'
import SiteLang from './SiteLang'
import { Menu } from 'semantic-ui-react'
import { Container} from 'semantic-ui-react'
import './css/Navi.css';

export default function Navi() {
    return (
        <div>
            {/* <CartSummary /> */}
            <Menu inverted fixed="top" size='small' className="main">

                <Container>

                    <Menu.Item
                        name='HRMS'

                    />
                    <Menu.Item
                        name='messages'

                    />
 
                    <Menu.Menu position='right'>
                        
                        {/* CartSummary file import */}

                        <Menu.Item>
                        <SiteLang/>
                            <div class="item">
                                <div class="ui primary button" size='small'>Sign up</div>
                            </div>
                            <div class="item" >
                                <div class="ui button" id="log_id">Log-in</div>
                            </div>
                        </Menu.Item>
                </Menu.Menu>
                </Container>
            </Menu>
            
        </div>
    )
}
