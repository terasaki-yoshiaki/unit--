package com.example.demo.sample1.Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.sample1.Model.DTO.sample1DTO;
import com.example.demo.sample1.Model.Databese.Database;

@Repository
public class sample1DAO {
	
	private Connection con = null;
	/**
	 * DBに接続する処理	
	 */
	public void connect() {
		try {
			// DBに接続
			con = Database.getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<sample1DTO> select() {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from sample1.staff";
		ArrayList<sample1DTO> list = new ArrayList<sample1DTO>();
		
		try {
			connect();
			stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
			
					while(rs.next()) {
						sample1DTO a1 = new sample1DTO();
						a1.setID(rs.getInt("id"));
						a1.setName(rs.getString("name"));
						a1.setAge(rs.getInt("age"));
						list.add(a1);
					}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void insert(sample1DTO dto) {
		// TODO 自動生成されたメソッド・スタブ
			Statement stmt = null;
			
			
			String name = dto.getName();
			int age = dto.getAge();
			String sql = "insert\n"
					+ "into sample1.staff(name,age)\n"
					+ "values('"+name+"','"+age+"')";
			ArrayList<sample1DTO> list = new ArrayList<sample1DTO>();
			
			try {
				connect();
				stmt = con.createStatement();
						stmt.executeUpdate(sql);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					
					stmt.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return;
		}
		
	}


