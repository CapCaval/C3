package org.capcaval.ccoutils.application;

import org.capcaval.ccoutils.askii.AskiiTools;
import org.capcaval.ccoutils.commandline.Command;
import org.capcaval.ccoutils.commandline.CommandParamDesc;
import org.capcaval.ccoutils.commandline.CommandWrapper;
import org.capcaval.ccoutils.formattedtext.Chap;
import org.capcaval.ccoutils.formattedtext.FormatText;
import org.capcaval.ccoutils.lang.StringTools;

public class HelpCommand {
	protected ApplicationDescription description;
	
	public HelpCommand(ApplicationDescription description){
		this.description = description;
	}
	
	@Command (defaultRun = true, desc = "Displays information about this application. It finds and \ndisplays all application properties and commands.")
	public String help(){
		String logo = null;
		if(this.description.appDetails.helpDisplayDetails != null){
			logo = AskiiTools.convertStringToAscii(
					this.description.appDetails.applicationName,
					this.description.appDetails.helpDisplayDetails.asciiLogoGradient,
					this.description.appDetails.helpDisplayDetails.helpDisplayidthInChar);
			}
		else{
			logo = this.description.appDetails.applicationName;
		}
		
		int displayWidth = 80;
		
		if(this.description.appDetails.helpDisplayDetails != null){
			displayWidth = this.description.appDetails.helpDisplayDetails.helpDisplayidthInChar;}
		
		// make a delimiter
		String delimiter = StringTools.repeatString("-", displayWidth);
		
		String author = "";
		if(this.description.appDetails.author != null){
			author = "by " + this.description.appDetails.author;
		}
		
		FormatText ft = new FormatText();
		ft.setColumnWidthInChar(80);
		
		StringBuffer buf =new StringBuffer();
		buf.append(ft.format(
				delimiter,
				logo,
				delimiter,
				Chap.level1 + "Version : " + this.description.appDetails.applicationVersion + "      " + author,
				Chap.level1 + "About:",
				Chap.level1 + StringTools.multiLineString(this.description.appDetails.aboutArray),
				Chap.none + delimiter,
				" "));
		buf.append(ft.format(Chap.level1 + "Properties :"));
		for( AppPropertyInfo info : this.description.applicationProperties.getAppPropertyInfoList()){
			buf.append(ft.format( Chap.level2 + "-"+info.type.getSimpleName() + " " + info.propertyName + " : " + info.comment));
		}
		buf.append("\n");
		
		buf.append(ft.format( Chap.level1 + "Commands :"));
		for( CommandWrapper command : this.description.commandLineComputer.getCommandWrapperList()){
			buf.append(ft.format( Chap.level2  + "-" + command.commandStr + " : " + command.descriptionStr));
			for(CommandParamDesc paramDesc : command.paramList){
				buf.append(ft.format( Chap.level3 + paramDesc.type.getSimpleName() + " " + paramDesc.name + " : " + paramDesc.description));
			}
		}
		
		return buf.toString();
	}
}
