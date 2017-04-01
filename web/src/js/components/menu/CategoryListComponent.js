import React from 'react'
import { connect } from "react-redux"
import { Link } from 'react-router'
import CategoryList from './CategoryList'
import CreateCategoryModal from '../modals/CreateCategoryModal'
import {getCategories, createCategory, deleteCategory} from '../../actions/categoryActions'
import {openModal, closeModal} from '../../actions/modalActions'

@connect( (store) =>{
	return {...store.category, modal: store.modal};
})
export default class CategoryListComponent extends React.Component{

    constructor(props) {
        super(props);
        const {items, dispatch} = this.props;
        if(!items.length) dispatch(getCategories());
        this.modalId = "categoryModal";
    }

    openModal(){
    	let id = this.modalId;
    	$("#" + id).modal('show');
    	let self = this;
        $('#' + id).one('hidden.bs.modal', function(e) {
        	self.props.dispatch(closeModal(id));
        });
    }

    closeModal(){
    	let id = this.modalId;
    	$("#" + id).off('hidden.bs.modal');
    	$("#" + id).modal('hide');
    }

    addClick(){
    	this.props.dispatch(openModal(this.modalId));
    }

    deleteClick(id){
    	this.props.dispatch(deleteCategory(id));
    }

    componentDidUpdate(){
    	if(this.props.modal.id != this.modalId) return;

    	if(this.props.modal.open) this.openModal();
    	else this.closeModal();
    }

	createCategory(title, image){
		this.props.dispatch(createCategory(title, image))
	}
	render(){
		return <div>
            <CreateCategoryModal modalId={this.modalId} 
            					 onSavePressed={this.createCategory.bind(this)}
            					 />
            					 
			<CategoryList onAddCategory={this.addClick.bind(this)}
						  items={this.props.items}
						  onDeleteCategory={this.deleteClick.bind(this)}
						  />
		</div>
                    
	}

}