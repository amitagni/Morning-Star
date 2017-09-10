
package com.ms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bean.SearchFormBean;
import com.ms.dto.SearchResultDTO;
import com.ms.dto.StudentDetailDTO;
import com.ms.entity.AbacusRegEntity;
import com.ms.entity.StudentInfo;
import com.ms.enums.House;
import com.ms.enums.Section;
import com.ms.enums.StudentClass;
import com.ms.service.SearchService;
import com.ms.util.MSConstant;
import com.ms.util.SessionUtil;

/**
 * @author Amit Agnihotri
 *
 */
@Controller
@Scope("request")
public class CommonController {


	@Autowired
	private SearchService searchService;

	
	/**
	 * @param login
	 * @param bindingResult
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/search", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView admission(@ModelAttribute("admissionFormBean") SearchFormBean searchFormBean, BindingResult bindingResult, Model model,HttpServletRequest request) {
		SessionUtil.setPage(MSConstant.SEARCH);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			return new ModelAndView("search", "searchFormBean", searchFormBean);
		}else{
			return new ModelAndView("search", "searchFormBean", searchFormBean);
		}
	}
	
	@RequestMapping(value = "/fetch-studentlist")
	public @ResponseBody List<SearchResultDTO> getStudentsList(HttpServletRequest request) {
		String studentName = request.getParameter("studentName");
        List<SearchResultDTO> studentList =  new ArrayList<SearchResultDTO>();
       /* studentList.add("Amit");
        studentList.add("Arnav");
        studentList.add("Aanvi");
        studentList.add("Alok");
        studentList.add("Arpit");*/
        List<StudentInfo> studentInfoList = searchService.findStudentsByName(studentName);
        if(studentInfoList != null){
        	for (StudentInfo studentInfo : studentInfoList) {
        		SearchResultDTO searchResultDTO = new  SearchResultDTO();
        		searchResultDTO.setValue(studentInfo.getId());
        		String stClass = StudentClass.findNameByCode(studentInfo.getCurrentClass());
        		String stSection = Section.findNameByCode(studentInfo.getSection());
        		if(stSection == null){
        			stSection = MSConstant.NOTAVAILABLE;
        		}
        		searchResultDTO.setLabel(studentInfo.getFirstName() +" : "+stClass+" : "+stSection);
        		studentList.add(searchResultDTO);
			}
        }
	
		return studentList;
	}
	
	@RequestMapping(value = "/fetch-studentDetail")
	public @ResponseBody StudentDetailDTO getStudentDetail(HttpServletRequest request) {
		String studentId = request.getParameter("studentId");
		StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
        StudentInfo studentInfo = searchService.findStudentsById(Integer.parseInt(studentId));
        if(studentInfo != null){
        	  studentDetailDTO.setId(studentInfo.getId());
        	  studentDetailDTO.setName(studentInfo.getFirstName() + " " + studentInfo.getLastName());
        	  studentDetailDTO.setFatherName(studentInfo.getFatherName());
        	  studentDetailDTO.setStudentClass(StudentClass.findNameByCode(studentInfo.getCurrentClass()));
        	  studentDetailDTO.setSection(Section.findNameByCode(studentInfo.getSection()));
        	  studentDetailDTO.setHouse(House.findNameByCode(studentInfo.getHouse()));
        	  studentDetailDTO.setPhotoPath(MSConstant.HTTPPATH + MSConstant.UPLOADDIR + "/"+studentInfo.getPhoto());
        }
      
		return studentDetailDTO;
	}
	
	@RequestMapping(value = "/fetch-abacus-studentlist")
	public @ResponseBody List<SearchResultDTO> getAbacusStudentsList(HttpServletRequest request) {
		String studentName = request.getParameter("studentName");
        List<SearchResultDTO> studentList =  new ArrayList<SearchResultDTO>();
       /* studentList.add("Amit");
        studentList.add("Arnav");
        studentList.add("Aanvi");
        studentList.add("Alok");
        studentList.add("Arpit");*/
        List<AbacusRegEntity> studentInfoList = searchService.findAbacusStudentsByName(studentName);
        if(studentInfoList != null){
        	for (AbacusRegEntity studentInfo : studentInfoList) {
        		SearchResultDTO searchResultDTO = new  SearchResultDTO();
        		searchResultDTO.setValue(studentInfo.getId());
        		/*String stClass = StudentClass.findNameByCode(studentInfo.getCurrentClass());
        		String stSection = Section.findNameByCode(studentInfo.getSection());
        		if(stSection == null){
        			stSection = MSConstant.NOTAVAILABLE;
        		}*/
        		searchResultDTO.setLabel(studentInfo.getFirstName() );
        		studentList.add(searchResultDTO);
			}
        }
	
		return studentList;
	}
	
	@RequestMapping(value = "/fetch-abacus-studentDetail")
	public @ResponseBody StudentDetailDTO getAbacusStudentDetail(HttpServletRequest request) {
		String studentId = request.getParameter("studentId");
		StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
		AbacusRegEntity studentInfo = searchService.findAbacusStudentsById(Integer.parseInt(studentId));
        if(studentInfo != null){
        	  studentDetailDTO.setId(studentInfo.getId());
        	  studentDetailDTO.setName(studentInfo.getFirstName() + " " + studentInfo.getLastName());
        	  studentDetailDTO.setFatherName(studentInfo.getFatherName());
        	 /* studentDetailDTO.setStudentClass(StudentClass.findNameByCode(studentInfo.getCurrentClass()));
        	  studentDetailDTO.setSection(Section.findNameByCode(studentInfo.getSection()));
        	  studentDetailDTO.setHouse(House.findNameByCode(studentInfo.getHouse()));
        	  studentDetailDTO.setPhotoPath(MSConstant.HTTPPATH + MSConstant.UPLOADDIR + "/"+studentInfo.getPhoto());*/
        }
      
		return studentDetailDTO;
	}

}
