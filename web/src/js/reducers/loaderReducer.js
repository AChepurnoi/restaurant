export default function reducer (
	state={
		show: false
	}, action){
	
	switch (action.type){

		case "LOADER_SHOW":{
			return {...state, show: true}
		}

		case "LOADER_HIDE":{
			return {...state, show: false}
		}

	}
	
	return state;
}