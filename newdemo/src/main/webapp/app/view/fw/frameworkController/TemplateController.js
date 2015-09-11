Ext.define("Buzzor.view.fw.frameworkController.TemplateController",{
	extend : 'Ext.app.ViewController',
	alias : "controller.TemplateController",
	
	onChange: function (me, newValue, oldValue, eOpts){
		var vm =this.view.getViewModel();
		vm.setData(newValue);
	},
	
	modifyComponents : function(configData){
		
		var items = this.view.items.items;
		for (var index =0 ; index < items.length ; index++) {
			
			if(items[index].isDynamic){
				var name = items[index].name;
				var inputValue = items[index].inputValue;
				var boxLable = items[index].boxLable;
				var componentDataArr = configData.groupData; 
				if(Array.isArray(componentDataArr)){
					
					for(var index2 = 0; index2 < componentDataArr.length ; index2++){
						var box = {boxLabel: componentDataArr[index2][boxLable],
								name : configData[name],
								bindValue : inputValue,
								inputValue: componentDataArr[index2][inputValue]};
						
						items[index].add(box);
					}
				}
			}	
		}	
		delete configData.groupData;
		this.view.getViewModel().setData(configData);		
	}
});