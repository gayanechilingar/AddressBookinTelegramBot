/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author gayanec
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeRequestZoomId {

    private Long contaciId; 
    private int zoomId;  
    
}